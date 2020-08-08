$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'bank/list',
        datatype: "json",
        colModel: [			
			{ label: 'id', name: 'id', index: 'id', width: 50, key: true },
			{ label: '账户类型 （1） 体现户 （2）签收户', name: 'type', index: 'type', width: 80 }, 			
			{ label: '渠道类型 （1） 京东智票 （2）京东智付', name: 'channeltype', index: 'channelType', width: 80 }, 			
			{ label: '银行新增来源 1)企业实名认证, (2)銀行卡管理打款', name: 'banksource', index: 'bankSource', width: 80 }, 			
			{ label: '银行名称', name: 'name', index: 'name', width: 80 }, 			
			{ label: '银行行号', name: 'number', index: 'number', width: 80 }, 			
			{ label: '开户行名称-同企业名称', name: 'accountname', index: 'accountName', width: 80 }, 			
			{ label: '开户账户', name: 'accountnumber', index: 'accountNumber', width: 80 }, 			
			{ label: '银行编码', name: 'occbankcode', index: 'occBankCode', width: 80 }, 			
			{ label: '银行名称', name: 'occbankname', index: 'occBankName', width: 80 }, 			
			{ label: '银行支行银联号', name: 'occbankcnap', index: 'occBankCnap', width: 80 }, 			
			{ label: '', name: 'occbankchildcode', index: 'occBankChildCode', width: 80 }, 			
			{ label: '支行银行全称', name: 'occbankchildname', index: 'occBankChildName', width: 80 }, 			
			{ label: '省份id', name: 'provinceid', index: 'provinceId', width: 80 }, 			
			{ label: '省份名称', name: 'provincename', index: 'provinceName', width: 80 }, 			
			{ label: '城市id', name: 'cityid', index: 'cityId', width: 80 }, 			
			{ label: '城市名称', name: 'cityname', index: 'cityName', width: 80 }, 			
			{ label: '创建时间', name: 'createtimeinmillis', index: 'createTimeInMillis', width: 80 }, 			
			{ label: '认证状态 - (0)待鉴权 (1)审核不通过 (2)审核通过', name: 'status', index: 'status', width: 80 }			
        ],
		viewrecords: true,
        height: 385,
        rowNum: 10,
		rowList : [10,30,50],
        rownumbers: true, 
        rownumWidth: 25, 
        autowidth:true,
        multiselect: true,
        pager: "#jqGridPager",
        jsonReader : {
            root: "page.list",
            page: "page.currPage",
            total: "page.totalPage",
            records: "page.totalCount"
        },
        prmNames : {
            page:"page", 
            rows:"limit", 
            order: "order"
        },
        gridComplete:function(){
        	//隐藏grid底部滚动条
        	$("#jqGrid").closest(".ui-jqgrid-bdiv").css({ "overflow-x" : "hidden" }); 
        }
    });
});

var vm = new Vue({
	el:'#rrapp',
	data:{
		showList: true,
		title: null,
		bank: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.bank = {};
		},
		update: function (event) {
			var id = getSelectedRow();
			if(id == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(id)
		},
		saveOrUpdate: function (event) {
		    $('#btnSaveOrUpdate').button('loading').delay(1000).queue(function() {
                var url = vm.bank.id == null ? "bank/save" : "bank/update";
                $.ajax({
                    type: "POST",
                    url: baseURL + url,
                    contentType: "application/json",
                    data: JSON.stringify(vm.bank),
                    success: function(r){
                        if(r.code === 0){
                             layer.msg("操作成功", {icon: 1});
                             vm.reload();
                             $('#btnSaveOrUpdate').button('reset');
                             $('#btnSaveOrUpdate').dequeue();
                        }else{
                            layer.alert(r.msg);
                            $('#btnSaveOrUpdate').button('reset');
                            $('#btnSaveOrUpdate').dequeue();
                        }
                    }
                });
			});
		},
		del: function (event) {
			var ids = getSelectedRows();
			if(ids == null){
				return ;
			}
			var lock = false;
            layer.confirm('确定要删除选中的记录？', {
                btn: ['确定','取消'] //按钮
            }, function(){
               if(!lock) {
                    lock = true;
		            $.ajax({
                        type: "POST",
                        url: baseURL + "bank/delete",
                        contentType: "application/json",
                        data: JSON.stringify(ids),
                        success: function(r){
                            if(r.code == 0){
                                layer.msg("操作成功", {icon: 1});
                                $("#jqGrid").trigger("reloadGrid");
                            }else{
                                layer.alert(r.msg);
                            }
                        }
				    });
			    }
             }, function(){
             });
		},
		getInfo: function(id){
			$.get(baseURL + "bank/info/"+id, function(r){
                vm.bank = r.bank;
            });
		},
		reload: function (event) {
			vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{ 
                page:page
            }).trigger("reloadGrid");
		}
	}
});