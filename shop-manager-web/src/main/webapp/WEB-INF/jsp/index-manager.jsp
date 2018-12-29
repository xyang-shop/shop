<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<div>
	<a class="easyui-linkbutton" onclick="importItems()">一键导入商品数据到索引库</a>
</div>
<script type="text/javascript">
	function importItems() {
		$.post("/index/import.action",null,function(data){
			alert(data.status);
			if (data.status == 200) {
				$.messager.alert('提示','商品数据导入完成！');
			} else {
				$.messager.alert('提示','商品数据导入失败！');
			}
		});
	}
</script>
