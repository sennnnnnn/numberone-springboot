/*
 * 汇智工具类 version 0.2
 * 2018 by Cheng Yang
 */
var HzTools = {

    showToast : false,

    toast : function(text, status) {
        if (this.showToast === true) {
            return;
        }
        var self = this, html = null;
        if (status === undefined) {
            html = '<div class="base-prompt visible" id="hz-toast"><span>'+text+'</span></div>';
        } else {
            if(status === true) {
                status = 'success' ;
            } else {
                status = 'error' ;
            }
            html = '<div class="base-toast visible '+status+'" id="hz-toast"><div class="wrapper"><div class="icon"></div><div class="msg">'+text+'</div></div></div>';
        }
        $('body').append(html);
        this.showToast = true;
        setTimeout(function () {
            $('#hz-toast').remove();
            self.showToast = false;
        }, 2500);
    },

    dialog : function (text, data, callback) {
        var self = this;
        $('body').append('<div class="base-dialog visible" id="hz-dialog"><div class="hd"><strong>提示</strong></div><div class="by">'+text+'</div><div class="ft clearFix"><div class="button cancel">取消</div><div class="button confirm">确认</div></div></div>');
        this.backdrop();

        $('#hz-dialog .cancel').one('click', function () {
            $('#hz-dialog').remove();
            self.backdrop(false);
        });
        $('#hz-dialog .confirm').one('click', function () {
            $('#hz-dialog').remove();
            self.backdrop(false);
            callback(data);
        });
    },

    loading : function (show, text) {
        if (show) {
            text = text === undefined ? '载入中请稍后' : text;
            $('body').append('<div class="base-toast loading visible" id="hz-loading"><div class="wrapper"><div class="loading-2"></div> <div class="msg">'+text+'</div></div></div>');
            this.backdrop();
        } else {
            $('#hz-loading').remove();
            this.backdrop(false);
        }
    },

    backdrop: function (bool) {
        if (bool === undefined) {
            $('body').append('<div class="backdrop visible" id="hz-backdrop"></div>');
        } else {
            $('#hz-backdrop').remove();
        }
    },

    copyValue : function (element) {
        var range = document.createRange();
        range.selectNode(element);
        var selection = window.getSelection();
        if(selection.rangeCount > 0) {
            selection.removeAllRanges()
        }
        selection.addRange(range);
        document.execCommand('copy');
    },

    getCookie : function (name, value) {
        if (document.cookie.length > 0) {
            var start = document.cookie.indexOf(name + "=");
            if (start !== -1) {
                start = start + name.length + 1;
                var end = document.cookie.indexOf(";", start);
                if (end === -1) end = document.cookie.length;
                return decodeURI(document.cookie.substring(start, end));
            }
        }
        return value;
    },

    getUrlParam : function (name) {
        var param = window.location.search.substring(1);
        var array = param.split("&");
        for (var i=0; i<array.length; i++) {
            var pair = array[i].split("=");
            if(pair[0] === name){
                return decodeURI(pair[1]);
            }
        }
        return null;
    },

    setUrlParam : function (param, value) {
        var url = window.location.href,
            preg = eval('/([?&])' + param + '=[^&]*/gi'),
            newUrl;
        if (preg.test(url)) {
            newUrl = url.replace(preg, "$1"+param+'='+value);
        } else {
            if (url.indexOf('?') !== -1) {
                newUrl = url + "&"+param+'='+value;
            } else {
                newUrl = url + "?"+param+'='+value;
            }
        }
        return newUrl;
    },

    valueType : function (o){
        var s = Object.prototype.toString.call(o);
        return s.match(/\[object (.*?)\]/)[1].toLowerCase();
    },

    copyright : function () {
        console.log('by: 橙风网络科技 dnscc.com');
    }
};