package com.jiubo.buildstore.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jiubo.buildstore.bean.RecruitBean;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jiubo.buildstore.bean.RecruitLabelListBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author syl
 * @since 2020-04-25
 */
public interface RecruitService extends IService<RecruitBean> {
    public Page<RecruitBean> getEasyInfo(RecruitBean recruitBean);

    public List<RecruitBean> getDetails(RecruitBean recruitBean);

    public Page<RecruitBean> getRecruitByPage(RecruitBean recruitBean);

    public void addRecruit(RecruitBean recruitBean);

    public void patchRecruitById(RecruitBean recruitBean);
    public RecruitLabelListBean getHotRe();
}
