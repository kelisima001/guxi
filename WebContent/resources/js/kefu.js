$(document).ready(function(){
	var i=0;
	$(".kefuTop").click(function(){
		if(i==0){
			console.log(i);
			$("#kefu").css("top","96%");
			i=1;
		}
		if(i==1){
			console.log(i);
			$("#kefu").css("top","40%");
			i=0;
		}
		
	});
});

