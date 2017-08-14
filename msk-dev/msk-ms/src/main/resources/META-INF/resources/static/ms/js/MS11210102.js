/**
 * @author fjm
   @MS11210102.js_会员卡密码修改js  
 */
var MS11210102 = {
		
		  formId : "MS11210102Form",
	saveButtonId : "MS11210102_SAVE",
	backButtonId : "MS11210102_BACK",

    init : function(){
        this.bindSavebutton(); 
        this.bindBackbutton();
        
    },
   
    bindSavebutton : function() {
		$("#" + MS11210102.saveButtonId).click(function() {
			MS11210102.saveData();
		});
	},	
    bindBackbutton : function() {
		$("#" + MS11210102.backButtonId).click(function() {
			$.pdialog.close();
		});
	},
	saveData : function() {
		var y=document.getElementById('msNowpw').value;
		var x=document.getElementById("msNowpw2").value;
		
		var validator = mainValidation($("#" + MS11210102.formId));
		var isValid = validator.form();
		if(x!==y){
			isValid=false;
			}
		if(y==null || y==""){
		document.getElementById('pwd_sp2').innerHTML="<font style='color:red'>密码不能为空！</font>";
		document.getElementById('pwd_sp').innerHTML="<font style='color:red'>密码不能为空！</font>";
		isValid=false;
		}
		if (isValid) {
			$.alertMessage.confirm("你确定要保存当前数据吗？", function() {
				$.alertMessage.close();
				formData = getFormData($("#" + MS11210102.formId));
				$('#main-content').postUrl(
						$("#" + MS11210102.formId).attr("action"),
						formData,
						function(data) {
							if(data=="1"){
								$.pdialog.close();
								$('#main-content').postUrl(Main.contextPath + "/MS112101/init");
							}else{
								document.getElementById('info_sp').innerHTML="<font style='color:red'>当前密码不一致！请重新填写！</font>";
							}
						},{refreshHtml:false});
			});
		}
	},

}


$(document).ready(function() {
    MS11210102.init();
}

);

function pwdTest(){
	var pwd=document.getElementById('msNowpw').value;
	if(pwd==null || pwd==""){
		document.getElementById('pwd_sp').innerHTML="<font style='color:red'>密码不能为空！</font>";
		return false;
	}
	document.getElementById('pwd_sp').innerHTML="";
	return true;
}

function pwdSure()
{
var y=document.getElementById('msNowpw').value;
var x=document.getElementById("msNowpw2").value;
if(x!==y){
	document.getElementById('pwd_sp2').innerHTML="<font style='color:red'>密码不一致！</font>";
	return false;
	}
  document.getElementById('pwd_sp2').innerHTML="";
	return true;
}
