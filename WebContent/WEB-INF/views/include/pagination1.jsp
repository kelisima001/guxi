<div class="pageBar" page="${page.pageNumber}" totalPages="${page.totalPages}">
	<ul class="pagination">
		<li class="first" isFirst="${page.first}"><a href="javascript:;" title="第一页">&laquo;</a></li>
		<li class="prev" hasPre="${page.hasPre}"><a href="javascript:;" title="上一页">&lt;</a></li>
		<li class="" page="${page.pageNumber}"><a href="javascript:;">${page.pageNumber}</a></li>
		<li class="next" hasNext="${page.hasNext}"><a href="javascript:;" title="下一页">&gt;</a></li>
		<li class="last" isLast="${page.last}"><a href="javascript:;" title="最后一页">&raquo;</a></li>
		<li><span>共${page.totalPages}页  ${page.total}条记录</span></li>
	</ul>
</div>