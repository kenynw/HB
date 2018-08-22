package com.santech.hongbao.app.constant;

/**
 * Copyright (c) 2018 Miguan Inc All rights reserved.
 * Created by Liaopeikun on 2018/6/19
 */
public interface ExtraConstant {

    String SERVER_CONFIG = "server_config"; // 需要服务器配置的数据

    /********************* 图片预览 ********************/
    String PREVIEW_IMAGE_DATA = "preview_image_data";//图片预览
    String PREVIEW_IMAGE_POSITION = "preview_image_position";//图片预览默认的显示位置

    /********************* 视频播放 ********************/
    String PLAY_VIDEO_DATA = "play_video_data";//视频播放列表
    String PLAY_VIDEO_CONTENT = "play_video_content";//底部显示的文字
    String PLAY_VIDEO_POSITION = "play_video_position";//列表的某个视频开始播放
    String PLAY_VIDEO_AUTO_PLAY = "play_video_auto_play";//是否自动播放

    String IS_ACTIVITY_INIT = "is_activity_init"; // 是否初始化

    String ACTIVITY_CONFIG = "activity_config";

    String TOKEN_ENTITY = "token_entity"; // 登录标识

    String USER_INFO = "user_bean"; // 用户信息

    String USER_ID = "user_id"; // 用户ID

    String USER_PHOTO = "user_photo"; // 用户头像

    String USER_NICKNAME = "user_nickname"; // 用户昵称

    String AUDITED = "audited"; // 是否已认证

    String ACCOUNT_TYPE = "account_type"; // 注册账号或者找回密码

    String WEB_URL = "web_url"; // 网页地址

    String BIND_STATUS = "bind_status"; // 绑定、未绑定状态

    String BIND_TYPE = "bind_type"; // 绑定类型

    String RECHARGE_TYPE = "recharge_type"; // 充值类型

    String PLATFORM_TYPE = "platform_type"; // 第三方平台类型

    String THIRD_ID = "third_id"; // 第三方平台唯一ID

    String ALIBIND_OR_UNBIND_TYPE = "alibind_or_unbind_type"; // 打开支付宝绑定、解绑界面
    String INCOME_TYPE = "income_type"; // 收入类型
    String CASH_OR_DIAMOND_DETAIL_TYPE = "cash_or_diamond_detail_type"; // 余额、钻石明细类型
    String INCOME_OR_DOKI_DETAIL_TYPE = "income_or_doki_detail_type"; // 现金收入、doki 明细类型

    String UDOMAIN = "UDOMAIN";// 上传青牛后返回的地址的域名
    String DETAIL_TYPE = "detail_type"; // 明细类型
    String CUSTOMDIALOG_TYPE = "customdialog_type"; // 自定义弹窗类型
    String ACCEPT_MAIN_ORDER_TYPE_LIST = "accept_main_order_type_list"; // 接单主品类集合
    String SELECT_LABEL = "select_label"; // 选择标签
    String WEEK_SETTING = "week_setting"; // 接单设置，重复日期
    String SELECT_HOBBY = "select_hobby"; // 选择兴趣
    String SELECT_JOB = "select_job"; // 选择工作
    String EXTRA_VERSION = "extra_version";//版本
    String REPORT_USERID = "report_userid";//被举报人id
    String NEED_UPDATE = "need_update"; // 是否需要更新

    /**
     * h5支付地址
     */
    String KEY_PAY_H5URL = "key_pay_h5url";

    /**
     * 关注或者粉丝类型
     */
    String FOLLOWS_TYPE = "follows_type";
    /**
     * 粉丝或者关注搜索类型
     */
    String FANS_SEARCH_TYPE = "fans_search_type";
    // 关注人数
    String SUBSCRIBE_COUNT = "subscribe_count";
    // 粉丝数量
    String FANS_COUNT = "fans_count";

    /********************* 技能 ********************/
    String SKILL_CATEGORY_OPEN_TYPE = "skill_category_open_type";//打开技能分类列表类型(默认、选择)
    String SKILL_ITEM = "skill_item";//传递Skill的item的key
    String USER_SKILL_ID = "user_skill_order"; // 用户技能的ID
    String SKILL_ID = "skill_id"; // 技能的ID
    String SKILL_NAME = "skill_name"; // 技能的名字
    String SKILL_PRICE = "skill_price"; // 技能价格
    String SKILL_TAG_LIST = "skill_tag_list"; // 标签列表
    String IS_AUDITED = "is_audited"; // 是否认证通过

    /**
     * 技能列表
     */
    String SKILL_LIST = "skill_list";
    String SKILL_LEVEL_LIST = "skill_level_list";

    // im消息eventBus key
    String IM_MESSAGE_BUNDLE_KEY = "im_message_key";
    // 通知类型，不展示界面的消息
    String IM_NOTIFY_MESSAGE_BUNDLE_KEY = "im_notify_message_key";
    // 会话id
    String MSG_TARGET_ID = "targetId";
    String MSG_PHOTO = "conversation_target_photo";
    // 会话标题
    String MSG_TITLE = "title";

    /********************* 拉黑的操作类型 ********************/
    String BLACK_TYPE = "black_type";//拉黑、移除黑名单


    /********************* 动态 ********************/
    String FEED_ID = "feed_id";//动态ID
    String FEED_LIST_TYPE = "feed_list_type";//动态类别：个人动态、关注、推荐、最新、技能、标签
    String FEED_LIST_PARAMS = "feed_list_params";//参数
    String FEED_LIST_TAG = "feed_list_tag";//动态列表tag
    String FEED_SELECT_TAG = "feed_select_tag";//选择tag返回

    /********************* 评论 ********************/
    String COMMENT_ID = "comment_id";//评论ID
    String COMMENT_DATA = "comment_data";//评论类型

    /********************* 订单 ********************/
    String ORDER_PUBLISH_ID = "order_publish_id";
    String ORDER_ID = "order_id";
    String ORDER_SOURCE = "order_source";
    String ORDER_COUNT = "order_count"; // 下单数量
    String ORDER_JUDGE_EXIST = "order_judge_exist"; //发布需求页面是否需要判断未完成订单
    String ORDER_GRAB_ID = "order_grab_id"; //抢单中心—>抢单详情页ID
    String ORDER_TYPE = "order_type"; // 订单类型
    String ORDER_LIST_TYPE = "order_list_type"; // 订单列表类型


    // 语音聊天的类型，接收方或者发送方
    String MSG_CHAT_VOICE_TYPE = "msg_chat_voice_type";
    // 用户信息
    String MSG_CHAT_USER_ENTITY = "msg_chat_user_entity";
}