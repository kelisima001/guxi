<c:if test="${success == true}">
	<div class="alert alert-success">
		<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		<span>${msg}</span>
	</div>
</c:if>
<c:if test="${success == false}">
	<div class="alert alert-danger alertbox">
		<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		<span>${msg}</span>
	</div>
</c:if>
<script>
	$(".alertbox").fadeIn();
	$(".close").click(function(){$(this).parent().fadeOut();})
	setTimeout(function(){$(".alertbox").fadeOut();},1000*3);
</script>	 