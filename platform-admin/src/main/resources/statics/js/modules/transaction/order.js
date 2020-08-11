$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'transaction/order/list',
        datatype: "json",
        colModel: [			
			{ label: 'id', name: 'id', index: 'id', width: 50, key: true },
			{ label: '订单类型', name: 'category', index: 'category', width: 80 },
			{ label: '订单状态', name: 'status', index: 'status', width: 80 },
			{ label: '意向价格', name: 'feededuction', index: 'feeDeduction', width: 80 },
			{ label: '平台服务费', name: 'servicefee', index: 'serviceFee', width: 80 }, 			
			{ label: '订单价格', name: 'value', index: 'value', width: 80 },
			{ label: '票据id', name: 'billid', index: 'billId', width: 80 }, 			
			{ label: '平台id', name: 'platformid', index: 'platformId', width: 80 }, 			
			{ label: '买方id', name: 'buyerid', index: 'buyerId', width: 80 }, 			
			{ label: '买方账号', name: 'directbuyeraccount', index: 'directBuyerAccount', width: 80 },
			{ label: '是否定向交易', name: 'isdirectsell', index: 'isDirectSell', width: 80 }, 			
			{ label: '支付地址', name: 'redirectpayurl', index: 'redirectPayUrl', width: 80 },
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
        q: {
            type: null,
            number: null,
            amount:null,
            status:null,
            sdate: null,
            edate: null,
            sellerId: null,
            buyerId: null,
            qcustomer: null
        },
		showList: true,
		title: null,
		order: {}
	},
    created: function () {
    },
    mounted: function () {
        this.initBaseData();
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
                postData: {
                    type: vm.q.type,
                    number: vm.q.number,
                    amount: vm.q.amount,
                    status: vm.q.status,
                    sdate: vm.q.sdate,
                    edate: vm.q.edate,
                    sellerId: vm.q.sellerId,
                    buyerId: vm.q.buyerId,
                    customer: vm.q.customer
                },
                page:page
            }).trigger("reloadGrid");
		},
        initBaseData: function () {
            let _self = this;
            $.ajax({
                type: "POST",
                async: false,
                url: baseURL + "employee/employee/all",
                contentType: "application/json",
                dataType: "json",
                success: function (r) {
                    if (r.code == 0) {
                        console.log(r.employeeEntities);
                        _self.customer = r.employeeEntities;
                        Vue.nextTick(function(){
                            _self.initQyChosenCustomer();
                        });
                    }
                }
            });
        },
        initQyChosenCustomer: function(){
            var optionHtml = '';
            optionHtml += '<option value="">' + "请选择客服"+ '</option>';
            $.each(vm.customer, function (ele, index, arr) {
                optionHtml += '<option value="' + index.id + '">' + index.name + '</option>';
            });
            let qcustomer = $('#qcustomer');
            qcustomer.html(optionHtml);
            qcustomer.chosen({
                no_results_text: "没有找到结果！",
                search_contains: true,
                allow_single_deselect: true,
                placeholder_text_multiple: "客服",
                width: "120px"
            });
            qcustomer.trigger("chosen:updated");
            qcustomer.on('change', function(evt, params) {
                //赋值
                vm.q.customer = qcustomer.val();
            });
        }
	}
});