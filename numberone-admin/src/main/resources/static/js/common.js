$(function () {
    $('#menu .name').click(function () {
        var expand = $(this).next('.expand');
        if (expand.hasClass('open')) {
            expand.removeClass('open')
        } else {
            expand.addClass('open')
        }
    });

});
function formSelect (element) {
    var element = $(element),
        value  = null,
        text   = null,
        oldVal = element.find('input.data').val();
    if (oldVal !== '') {
        text = element.find(".options span[data-val='"+oldVal+"']").text();
        if (text !== '') {
            element.find('.input-static').text(text).addClass('selected');
        }
    }
    element.find('.input-static').click(function (e) {
        if (element.hasClass('open')) {
            element.removeClass('open');
        } else {
            element.addClass('open');
        }
        $(document).one("click", function(){
            element.removeClass('open');
        });
        e.stopPropagation();
    });
    element.on('click', '.options span',function (e) {
        value = $(this).attr('data-val');
        text  = $(this).text();
        element.find('input.data').val(value);
        element.find('.input-static').text(text).addClass('selected');
        element.removeClass('open');
    });
    element.on('click', '.options', function (e) {
        e.stopPropagation();
    });
    return this;
}
