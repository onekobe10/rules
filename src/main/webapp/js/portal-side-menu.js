/**
 * Created by jin on 2015/11/18.
 */
$(function(){
    //���˵��̶�
    $('#side_nav').affix({
        offset: {
            bottom: $('footer').outerHeight(true) + $('.application').outerHeight(true) + 40
        }
    });
    //�����˵������¼�
    $('.menu-second').on('hidden.bs.collapse', function () {
        if($(this).hasClass('in')){
            return;
        }
        var obj=$('[href=#'+$(this).attr('id')+']').find(".glyphicon-chevron-right");
        obj.removeClass('glyphicon-chevron-right');
        obj.addClass('glyphicon-chevron-down');

    });
    //�����˵����¼�
    $('.menu-second').on('show.bs.collapse', function () {
        var obj=$('[href=#'+$(this).attr('id')+']').find(".glyphicon-chevron-down");
        obj.removeClass('glyphicon-chevron-down');
        obj.addClass('glyphicon-chevron-right');
    })
    //�����˵��ر��¼�
    $('.menu-third').on('hidden.bs.collapse', function () {
        var obj=    $('[href=#'+$(this).attr('id')+']');
        obj.html(obj.attr('title'));
    });
    //���������²˵����¼�
    $('.menu-third').on('show.bs.collapse', function () {
        var obj=    $('[href=#'+$(this).attr('id')+']');
        obj.html('<span class="glyphicon glyphicon-th-large" aria-hidden="true" /> '+obj.attr('title'));
    })
})