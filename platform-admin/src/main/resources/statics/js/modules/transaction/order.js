$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'transaction/order/list',
        datatype: "json",
        colModel: [			
			{ label: 'id', name: 'id', index: 'id', width: 50, key: true },
			{ label: '订单类型（|1|入平台 |2|出平台 |3|财务）', name: 'category', index: 'category', width: 80 }, 			
			{ label: '订单状态（|-1|已取消 |2|议价中 |3|议价成功 |4|议价被拒绝 |200|待打款 |201|待背书 |202|待签收 |203|待校验 |204|交易成功 |205|交易失败 |206|校验失敗）', name: 'status', index: 'status', width: 80 }, 			
			{ label: '意向价格（每十万扣款）', name: 'feededuction', index: 'feeDeduction', width: 80 }, 			
			{ label: '平台服务费', name: 'servicefee', index: 'serviceFee', width: 80 }, 			
			{ label: '订单价格（交易金额？）', name: 'value', index: 'value', width: 80 }, 			
			{ label: '票据id', name: 'billid', index: 'billId', width: 80 }, 			
			{ label: '平台id', name: 'platformid', index: 'platformId', width: 80 }, 			
			{ label: '买方id', name: 'buyerid', index: 'buyerId', width: 80 }, 			
			{ label: '买方账号？', name: 'directbuyeraccount', index: 'directBuyerAccount', width: 80 }, 			
			{ label: '是否定向交易', name: 'isdirectsell', index: 'isDirectSell', width: 80 }, 			
			{ label: '支付地址（京东返回）', name: 'redirectpayurl', index: 'redirectPayUrl', width: 80 }, 			
			{ label: '请求流水号', name: 'reqno', index: 'reqNo', width: 80 }, 			
			{ label: '交易id', name: 'transactionid', index: 'transactionId', width: 80 }			
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
		order: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.order = {};
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
                var url = vm.order.id == null ? "transaction/order/save" : "transaction/order/update";
                $.ajax({
                    type: "POST",
                    url: baseURL + url,
                    contentType: "application/json",
                    data: JSON.stringify(vm.order),
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
                        url: baseURL + "transaction/order/delete",
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
			$.get(baseURL + "transaction/order/info/"+id, function(r){
                vm.order = r.order;
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