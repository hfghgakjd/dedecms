/**
 * 
 */
$("#tt").datagrid(
		{
			columns : [ [
					{
						field : 'ck',
						checkbox : true
					},
					{
						field : 'text',
						title : '菜单名称',
						width : 80,
						align : 'center'
					},
					{
						field : 'url',
						title : '路径',
						width : 100,
						align : 'center'
					},
					{
						field : 'iconCls',
						title : '图标样式',
						formatter : function(val, row) {
							return '<i class="' + val
									+ '" style="padding-right:10px;"></i>'
									+ val;
						},
						width : 80,
						align : 'center'
					}, {
						field : 'isLeaf',
						title : '是否叶子节点',
						width : 80,
						align : 'center'
					}, {
						field : 'parentId',
						title : '父级菜单',
						width : 250,
						align : 'center'
					}, {
						field : 'state',
						title : '默认展开',
						width : 130,
						align : 'center'
					} ] ]
		});

/**
 * 打开新增菜单的panel
 * 
 * @returns
 */
function showAdd() {
	$('#win').window('open');
}

/**
 * 保存新增的菜单
 * 
 * @returns
 * @auhtor snowfog shao
 */
function save() {
	$.ajax({
		url : '/menu/save',
		method : 'post',
		data : $('#ff').serialize(),
		beforeSend : function() {
			console.log("加载中...请稍候...");
		},
		success : function(data) {
			if (data.isSave == true) {
				console.log('恭喜你!插入成功!');
			} else {
				console.log('很遗憾，发生错误，未能新增!');
			}
		}
	})
}