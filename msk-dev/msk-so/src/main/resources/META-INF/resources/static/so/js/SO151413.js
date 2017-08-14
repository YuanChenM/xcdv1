/**
 * 订单JS
 *
 * @author sjj
 */
var SO151413 = {
    formId: "SO151413Form",
    init: function () {
        this.exportOrder();
    },
    exportOrder: function () {
        $("#SO151413_EXPORT").click(function () {
            var dform = $("<form>");   //定义一个form表单
            dform.append('<input type="text" name="slShowName" value="' + $("#slShowName").val() + '">')
            dform.append('<input type="text" name="pdCode" value="' + $("#pdCode").val() + '">')

            dform.attr('style', 'display:none');   //在form表单中添加查询参数
            dform.attr('target', '');

            dform.attr('method', 'post');
            dform.attr('action', Main.contextPath + "/SO151413/exportOrder");
            $('body').append(dform);  //将表单放置在web中
            dform.submit();
        });
    }
}

$(function () {
    SO151413.init();
});
