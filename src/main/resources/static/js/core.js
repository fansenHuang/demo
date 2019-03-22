/**
 * 核心js，公共function
 */

/**
 * 启用-停用
 */
function statusFun(ID, url, url2) {
	$.ajax({
		url : url,
		data : {
			"id" : ID
		},
		success : function(status) {
			if (status == 0) {
				layer.confirm('确认要停用吗？', function(index) {
					$.ajax({
						url : url2,
						data : {
							"id" : ID,
							"status" : 1
						},
						success : function() {
							$("#" + ID).addClass("layui-bg-red").html("未启用");
							layer.msg('已停用!', {
								icon : 2,
								time : 1000
							});
						}
					});

				});
			} else {
				layer.confirm('确认要启用吗？', function(index) {
					$.ajax({
						url : url2,
						data : {
							"id" : ID,
							"status" : 0
								},
						success : function() {
							$("#" + ID).removeClass("layui-bg-red").html("已启用");
							layer.msg('已启用!', {
								icon : 1,
								time : 1000
									});
								}
							});
				});
			}
		}

	})

}

/*单个删除*/
function member_del(obj, id, url) {
	layer.confirm('确认要删除吗？', function(index) {
		$.ajax({
			url : url,
			data : {
				"data" : id
			},
			success : function() {
				$(obj).parents("tr").remove();
				layer.msg('已删除!', {
					icon : 1,
					time : 1000
				});
				window.location.reload();
			}
		});

	});
}

/**
 * 批量删除
 * @param url
 * @returns
 */
function delAll(url) {

	var data = tableCheck.getData();
	if (data == '' || data == null) {
		layer.msg('请选择要删除的数据', {
			icon : 7
		});
		return;
	}
	layer.confirm('确认要删除吗？' + data, function(index) {

		$.ajax({
			url : url,
			data : {
				"data" : data.join(',')
			},
			success : function() {
				layer.msg('删除成功', {
					icon : 1
				});
				$(".layui-form-checked").not('.header').parents('tr').remove();
			}
		});
	});
}