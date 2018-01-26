<div class="modal fade" tabindex="-1" role="dialog" id="imageSelectorModal">
  <div class="modal-dialog modal-lg" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title">图片选择器</h4>
      </div>
      <div class="modal-body">
      	<c:forEach var="image" items="${uploadedImages}">
      	<img src="upload/${image}" title="upload/${image}" data-dismiss="modal" />
      	</c:forEach>
      	<div style="clear:both;"></div>
      </div>
    </div>
  </div>
</div>