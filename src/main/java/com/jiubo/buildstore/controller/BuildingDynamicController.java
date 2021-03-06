package com.jiubo.buildstore.controller;


import com.alibaba.fastjson.JSONObject;
import com.jiubo.buildstore.bean.BuildingBean;
import com.jiubo.buildstore.bean.BuildingDynamicBean;
import com.jiubo.buildstore.common.Constant;
import com.jiubo.buildstore.service.BuildingDynamicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author syl
 * @since 2020-04-10
 */
@RestController
@Scope("prototype")
@RequestMapping("/buildingDynamicBean")
public class BuildingDynamicController {

    @Autowired
    private BuildingDynamicService buildingDynamicService;


    @PostMapping("/getDynamicByBid")
    public JSONObject getDynamicByBid(BuildingDynamicBean buildingDynamicBean) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(Constant.Result.RETCODE, Constant.Result.SUCCESS);
        jsonObject.put(Constant.Result.RETMSG, Constant.Result.SUCCESS_MSG);
        jsonObject.put(Constant.Result.RETDATA,buildingDynamicService.getDynamicByBid(buildingDynamicBean));
        return jsonObject;
    }

    /**
     * 移动端详情动态
     * @param buildingDynamicBean
     * @return
     */
    @PostMapping("/getNewestDynamicByBid")
    public JSONObject getNewestDynamicByBid(BuildingDynamicBean buildingDynamicBean) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(Constant.Result.RETCODE, Constant.Result.SUCCESS);
        jsonObject.put(Constant.Result.RETMSG, Constant.Result.SUCCESS_MSG);
        jsonObject.put(Constant.Result.RETDATA,buildingDynamicService.getNewestDynamicByBid(buildingDynamicBean));
        return jsonObject;
    }

    @PostMapping("/getDynamicByPage")
    public JSONObject getDynamicByPage(@RequestBody BuildingDynamicBean buildingDynamicBean) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(Constant.Result.RETCODE, Constant.Result.SUCCESS);
        jsonObject.put(Constant.Result.RETMSG, Constant.Result.SUCCESS_MSG);
        jsonObject.put(Constant.Result.RETDATA,buildingDynamicService.getDynamicByPage(buildingDynamicBean));
        return jsonObject;
    }

    @PostMapping("/patchDyById")
    public JSONObject patchDyById(@RequestBody String param) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(Constant.Result.RETCODE, Constant.Result.SUCCESS);
        jsonObject.put(Constant.Result.RETMSG, Constant.Result.SUCCESS_MSG);
        BuildingDynamicBean buildingDynamicBean = JSONObject.parseObject(param, BuildingDynamicBean.class);
        buildingDynamicService.patchDyById(buildingDynamicBean);
        return jsonObject;
    }

    @PostMapping("/addDynamic")
    public JSONObject addDynamic(@RequestBody String param) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(Constant.Result.RETCODE, Constant.Result.SUCCESS);
        jsonObject.put(Constant.Result.RETMSG, Constant.Result.SUCCESS_MSG);
        BuildingDynamicBean buildingDynamicBean = JSONObject.parseObject(param, BuildingDynamicBean.class);
        buildingDynamicService.addDynamic(buildingDynamicBean);
        return jsonObject;
    }
}
