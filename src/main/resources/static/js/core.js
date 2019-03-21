/**
 * 核心js，公共function
 */
/*单个删除*/
function member_del(obj, id,url) {
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