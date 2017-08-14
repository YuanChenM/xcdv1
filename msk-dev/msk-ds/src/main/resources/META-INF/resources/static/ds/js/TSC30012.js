

var TSC30012 = {
    time: "#time",
    init: function () {
        this.bindDatePicber(TSC30012.time);
        this.addData();
    },
    bindDatePicber: function (timeID) {
        $(timeID).datepicker({
            showButtonPanel: true,
            dateFormat: 'yy-mm-dd',
            changeMonth: true,
            changeYear: true
        });
    },
    addData:function(){
        $("#addRow").click(function(){
            var data="<tr> <td align='center'><input type='text' id='20' value=''  style='width:180px;'/></td> <td align='center'><input type='text' id='21' value=''/></td> <td align='center'><input type='text' id='22' value='' /></td> <td align='center'><input type='text' id='23' value='' /></td> <td align='center'><input type='text' id='24' value='' /></td> </tr>";
            $("#add").after(data);
            var rowData=parseInt($("#row").attr("rowspan"))+1;
            $("#row").attr("rowspan",rowData);
        });
    }
}
$(document).ready(function () {
    TSC30012.init();
});

