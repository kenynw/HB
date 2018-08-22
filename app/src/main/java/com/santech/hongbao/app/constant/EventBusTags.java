package com.santech.hongbao.app.constant;

import org.simple.eventbus.EventBus;

/**
 * ================================================
 * 放置 {@link EventBus} 的 Tag ,便于检索
 *
 * @see <a href="https://github.com/JessYanCoding/MVPArms/wiki#3.5">EventBusTags wiki 官方文档</a>
 * Created by JessYan on 8/30/2016 16:39
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * ================================================
 */
public interface EventBusTags {

    String UPDATE_THIRD_BIND = "update_third_bind";

    /**
     * 收到新消息
     */
    String IM_RECEIVE_MESSAGE = "im_receive_message";
    String IM_RECEIVE_NOTIFY_MESSAGE = "im_notify_receive_message";

    /************************ 拉黑用户 ************************/
    String COMMON_BLACK_OR_UN_BLACK_USER_SUCCESS = "common_black_or_un_black_user_success";
    String COMMON_BLACK_OR_UN_BLACK_USER_FAIL = "common_black_or_un_black_user_fail";

    /************************ 动态相关 ************************/
    String FEED_LIKE = "feed_like";//动态喜欢不喜欢
    String FEED_DELETE = "feed_delete";//动态删除
    String FEED_PUBLISH_SUCCESS = "feed_publish_success";//动态发布成功
    String FEED_COMMENT_DELETE_SUCCESS = "feed_comment_delete_success";//评论删除成功

    /**
     * 增加评论
     */
    String COMMENT_ADD = "comment_add";

    /**
     * 评论喜欢不喜欢
     */
    String COMMENT_LIKE = "comment_like";
    /**
     * 单张图片选中后的地址
     */
    String SINGLE_PIC_URL = "single_pic_url";


    /**
     * 唤起支付
     */
    String CODE_WECHAT_PAY = "code_wechat_pay";

    /**
     * 融云连接成功
     */
    String RC_CONNECT_SUCCESS = "rc_connect_success";
    /**
     * 刷新个人信息
     */
    String UPDATE_USER_INFO = "update_user_info";
    /**
     * 充值成功
     */
    String RECHARGE_SUCCESS = "recharge_success";
    /**
     * 刷新粉丝列表
     */
    String UPDATE_FOLLOW_LIST = "update_follow_list";
    /**
     * 身份认证成功
     */
    String IDENT_AUDIT_SUCCESS = "ident_audit_success";

    /**
     * 更新未读消息
     */
    String UPDATE_UNREAD_MSG = "update_unread_msg";

    /**
     * 更新消息Fragment里的未读消息
     */
    String UPDATE_FRAGMENT_UNREAD_MSG = "update_fragment_unread_msg";

    /**
     * 当录制语音时应用进入后台
     */
    String ON_RECORDER_PAUSE = "on_recorder_pause";

    /************************ 订单相关 ************************/
    String ORDER_CANCEL_SUCCESS = "order_cancel_success";//取消订单
    String ORDER_CANCEL_FAIL = "order_cancel_fail";//取消订单
    String ORDER_GRAB_SUCCESS = "order_grab_success";//抢单成功
    String ORDER_ACCEPT_SUCCESS = "order_accept_success";//接单成功
    String ORDER_ACCEPT_FAIL = "order_accept_fail";//接单失败
    String ORDER_REFUSE_SUCCESS = "order_refuse_success";//拒绝订单成功
    String ORDER_REFUSE_FAIL = "order_refuse_fail";//拒绝订单失败
    String ORDER_PAY_SUCCESS = "order_pay_success";//订单支付成功
    String ORDER_COMPLETE_SUCCESS = "order_complete_success";//完成订单成功
    String ORDER_COMPLETE_FAIL = "order_complete_fail";//完成订单失败
    String ORDER_REFUND_SUCCESS = "order_refund_success";//申请退款成功
    String ORDER_REFUND_FAIL = "order_refund_fail";//申请退款失败
    String ORDER_REFUND_AGREE_SUCCESS = "order_refund_agree_success";//同意退款成功
    String ORDER_REFUND_AGREE_FAIL = "order_refund_agree_fail";//同意退款失败
    String ORDER_REFUND_DISAGREE_SUCCESS = "order_refund_disagree_success";//拒绝退款成功
    String ORDER_REFUND_DISAGREE_FAIL = "order_refund_disagree_fail";//拒绝退款失败
    String ORDER_EVALUATE_SUCCESS = "order_evaluate_success";//评价成功
    String ORDER_EVALUATE_FAIL = "order_evaluate_fail";//评价失败

    String ORDER_PUBLISH_ACCEPT = "order_publish_accept";//需求等待接单页面，监听是否有接单
    String ORDER_GRAB_MESSAGE = "order_grab_message";//有新的抢单消息
    String ORDER_APPLY_COMPLAINT = "order_apply_complaint";//提交申诉成功
    // 操作订单后订单状态改变，在本地插入一条状态消息，通知聊天页面或者会话页面更新
    String MSG_ORDER_STATE_CHANGED = "msg_order_state_changed";

    //************************ AppManagerEvent ************************/
    /**
     * 重新登录事件, 封号或者封设备
     */
    int EVENT_RE_LOGIN = 0x001;

    /**
     * 在其他地方登录
     */
    int KICKED_OFFLINE_BY_OTHER_CLIENT = 0x002;

    /**
     * 没有权限
     */
    int DEAL_WITH_NO_PERMISSION = 0x003;

    /**
     * 如果在应用内不显示通知
     */
    int CLEAR_ALL_NOTIFICATION = 0x004;

    /**
     * 登录成功进入首页
     */
    int ON_LOGIN_SUCCESS = 0x005;

}
