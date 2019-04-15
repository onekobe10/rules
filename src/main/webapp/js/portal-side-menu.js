/**
 * Created by jin on 2015/11/18.
 */
$(function(){
    //左侧菜单固定
    $('#side_nav').affix({
        offset: {
            bottom: $('footer').outerHeight(true) + $('.application').outerHeight(true) + 40
        }
    });
    //二级菜单隐藏事件
    $('.menu-second').on('hidden.bs.collapse', function () {
        if($(this).hasClass('in')){
            return;
        }
        var obj=$('[href=#'+$(this).attr('id')+']').find(".glyphicon-chevron-right");
        obj.removeClass('glyphicon-chevron-right');
        obj.addClass('glyphicon-chevron-down');

    });
    //二级菜单打开事件
    $('.menu-second').on('show.bs.collapse', function () {
        var obj=$('[href=#'+$(this).attr('id')+']').find(".glyphicon-chevron-down");
        obj.removeClass('glyphicon-chevron-down');
        obj.addClass('glyphicon-chevron-right');
    })
    //三级菜单关闭事件
    $('.menu-third').on('hidden.bs.collapse', function () {
        var obj=    $('[href=#'+$(this).attr('id')+']');
        obj.html(obj.attr('title'));
    });
    //三级及以下菜单打开事件
    $('.menu-third').on('show.bs.collapse', function () {
        var obj=    $('[href=#'+$(this).attr('id')+']');
        obj.html('<span class="glyphicon glyphicon-th-large" aria-hidden="true" /> '+obj.attr('title'));
    })
})