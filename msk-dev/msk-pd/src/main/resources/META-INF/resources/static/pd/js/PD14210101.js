/**
 * 品种产品目录表表
 *
 * @author xhy
 */

var PD14210101 = {
    PD14210101Grid: null,
    init: function () {
        this.PD14210101Grid = $('#PD14210101_list_grid').grid();
        this.searchData();
    },
    searchData: function () {
        $("#PD14210101_SEARCH").click(function () {
            PD14210101.PD14210101Grid.fnDraw();
        });
        $('#PD14210101_list_grid').find('thead.filterHeader').on('keydown', 'input,select',function(evt){
            if(evt.keyCode == 13 || evt.keyCode == 37 || evt.keyCode==39)
            {
                $('.hasDatepicker').datepicker('hide');
                switch(evt.keyCode){
                    case 13:    // Enter
                        if($(this).attr("type") == "text"){
                            PD14210101.PD14210101Grid.fnDraw();
                        }
                        break;
                }
            }
        });
    }
};
$(document).ready(function () {
    // 初始化调用
    PD14210101.init();
});
