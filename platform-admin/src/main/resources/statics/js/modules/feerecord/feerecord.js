$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'feerecord/feerecord/list',
        datatype: "json",
        colModel: [			
			{ label: '编号', name: 'id', index: 'id', width: 50, key: true },
			{ label: '费用类型', name: 'feetype', index: 'feeType', width: 80 ,formatter:function(cellvalue, options, rowObject) {
                if(cellvalue == 0){
                    return "未知";
                }else if(cellvalue == 1){
                    return "票据发布费";
                }else if(cellvalue == 2){
                    return "平台服务费";
                }else if(cellvalue == 4){
                    return "见证服务费";
                }else if(cellvalue == 8){
                    return "资金结算费";
                }
            } },
			{ label: '平台费用', name: 'platformFee', index: 'platform_fee', width: 80 }, 			
			{ label: '渠道费用', name: 'channelFee', index: 'channel_fee', width: 80 }, 			
			// { label: '支付方ID', name: 'payerid', index: 'payerId', width: 80 },
			{ label: '支付方姓名', name: 'payername', index: 'payerName', width: 80 }, 			
			// { label: '买方id', name: 'buyerid', index: 'buyerId', width: 80 },
			{ label: '买方姓名', name: 'buyername', index: 'buyerName', width: 80 }, 			
			// { label: '卖方id', name: 'sellerid', index: 'sellerId', width: 80 },
			{ label: '卖方姓名', name: 'sellername', index: 'sellerName', width: 80 }, 			
			{ label: '票号', name: 'billnumber', index: 'billNumber', width: 80 }, 			
			// { label: '票据id', name: 'billid', index: 'billId', width: 80 },
			{ label: '订单号', name: 'orderid', index: 'orderId', width: 80 }, 			
			// { label: '发布平台id', name: 'releasePlatformid', index: 'release_platformId', width: 80 },
			{ label: '发布平台', name: 'releasePlatform', index: 'release_platform', width: 80 }, 			
			{ label: '交易平台', name: 'transactionPlatform', index: 'transaction_platform', width: 80 }, 			
			// { label: '交易平台id', name: 'transactionPlatformid', index: 'transaction_platformId', width: 80 },
			{ label: '日期', name: 'createtimeinmillis', index: 'createTimeInMillis', width: 80 }
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
		feerecord: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.feerecord = {};
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
                var url = vm.feerecord.id == null ? "feerecord/feerecord/save" : "feerecord/feerecord/update";
                $.ajax({
                    type: "POST",
                    url: baseURL + url,
                    contentType: "application/json",
                    data: JSON.stringify(vm.feerecord),
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
                        url: baseURL + "feerecord/feerecord/delete",
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
			$.get(baseURL + "feerecord/feerecord/info/"+id, function(r){
                vm.feerecord = r.feerecord;
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