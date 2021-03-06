package com.jiubo.buildstore.dao;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jiubo.buildstore.bean.CounselorCommentBean;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author syl
 * @since 2020-04-10
 */
public interface CounselorCommentDao extends BaseMapper<CounselorCommentBean> {

    /**
     * 前端楼盘详情
     * @param
     * @param counselorCommentBean
     * @return
     */
    public List<CounselorCommentBean> getCounselorByBid(@Param("counselorCommentBean") CounselorCommentBean counselorCommentBean);

    /**
     * 点赞
     * @param counselorCommentBean
     */
    public int updateNumById(@Param("counselorCommentBean") CounselorCommentBean counselorCommentBean);

    public List<CounselorCommentBean> getCidByBidList(@Param("counselorCommentBean") CounselorCommentBean counselorCommentBean);

    /**
     * 后台管理
     * @param page
     * @param counselorCommentBean
     * @return
     */
    public List<CounselorCommentBean> getComByPage(Page page,@Param("counselorCommentBean") CounselorCommentBean counselorCommentBean);

    /**
     * 后台管理更新
     * @param counselorCommentBean
     */
    public void updateComById(@Param("counselorCommentBean") CounselorCommentBean counselorCommentBean);

    public int addCom(@Param("counselorCommentBean") CounselorCommentBean counselorCommentBean);


    // 根据评论ID查询点赞数
    public CounselorCommentBean  queryCounselorComment(CounselorCommentBean counselorCommentBean);
}
