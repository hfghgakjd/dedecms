(function () {
    $.ajax({
        type: 'POST',
        dataType: "json",
        url: 'menu/getAll',
        success: function (data) {
            $.each(data, function (i, n) {
                $('#aa').accordion('add', {
                    title: n.name,
                    selected: false,
                    id: n.id,
                    iconCls: n.icon,
                    content: '<div style="padding:10px"><ul id="tree_' + n.id + '"></ul></div>'
                });
            });
        }
    });
    $('#aa').accordion({
        fit: true,
        border: false,
        animate: true,
        onSelect: function (e, v) {
            var p = $('#aa').accordion('getSelected');
            var containId = p.panel('options').id;
            $("#tree_" + containId).tree({
                url: "/menu/getTrees",
                onBeforeLoad: function (node, param) {
                    param.pId = containId
                },
                method: "POST",
                onClick: function (node) {
                    //判断是否是叶子节点
                    if (node.leaf == true) {
                        if ($('#tabs').tabs('exists', node.text)){
                            $("#tabs").tabs("select", node.text);
                        } else {
                            var content = '<iframe scrolling="auto" frameborder="0" src="'+node.url+'" ' +
                                'style="width:100%;height:100%;" id="'+node.id+'"></iframe>';
                            $("#tabs").tabs('add', {
                                title: node.text,
                                content: content,
                                closable: true
                            });
                        }
                    }
                }
            });
        }
    }, 2);
})();