$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'bill/bill/list',
        datatype: "json",
        colModel: [			
			{ label: 'id', name: 'id', index: 'id', width: 50, key: true },
			{ label: '票号', name: 'number', index: 'number', width: 80 }, 			
			{ label: '票据类型', name: 'type', index: 'type', width: 80 }, 			
			{ label: '出票人姓名', name: 'drawername', index: 'drawerName', width: 80 }, 			
			{ label: '收票人姓名', name: 'draweename', index: 'draweeName', width: 80 }, 			
			{ label: '承兑银行名称', name: 'acceptingbankname', index: 'acceptingBankName', width: 80 }, 			
			{ label: '承兑银行行号', name: 'acceptingbanknumber', index: 'acceptingBankNumber', width: 80 }, 			
			{ label: '承兑银行类型', name: 'acceptingbanktype', index: 'acceptingBankType', width: 80 }, 			
			{ label: '票面金额', name: 'amount', index: 'amount', width: 80 }, 			
			{ label: '签发日', name: 'issuedate', index: 'issueDate', width: 80 }, 			
			{ label: '到期日', name: 'duedate', index: 'dueDate', width: 80 }, 			
			{ label: '票据正面图URL', name: 'coverfrontpictureurl', index: 'coverFrontPictureUrl', width: 80 }, 			
			{ label: '票据背面图URL', name: 'coverbackpictures', index: 'coverBackPictures', width: 80 }, 			
			{ label: '担保渠道', name: 'channeltype', index: 'channelType', width: 80 }, 			
			{ label: '回款银行账户资讯', name: 'transferbank', index: 'transferBank', width: 80 }, 			
			{ label: '背书户银行资讯', name: 'endorsebank', index: 'endorseBank', width: 80 }, 			
			{ label: '背书次数', name: 'endorsecount', index: 'endorseCount', width: 80 }, 			
			{ label: '回出票人状态 |-1|取消/未知 |0|否/无 |1|是/有', name: 'returndrawerstatus', index: 'returnDrawerStatus', width: 80 }, 			
			{ label: '回收款人状态 |-1|取消/未知 |0|否/无 |1|是/有', name: 'returndraweestatus', index: 'returnDraweeStatus', width: 80 }, 			
			{ label: '回头背书状态 |-1|取消/未知 |0|否/无 |1|是/有', name: 'returnendorsementstatus', index: 'returnEndorsementStatus', width: 80 }, 			
			{ label: '重复背书状态 |-1|取消/未知 |0|否/无 |1|是/有', name: 'doubleendorsementstatus', index: 'doubleEndorsementStatus', width: 80 }, 			
			{ label: '质押状态 |-1|取消/未知 |0|否/无 |1|是/有', name: 'pledgestatus', index: 'pledgeStatus', width: 80 }, 			
			{ label: '保证状态 |-1|取消/未知 |0|否/无 |1|是/有', name: 'guaranteestatus', index: 'guaranteeStatus', width: 80 }, 			
			{ label: '上下不一致状态 |-1|取消/未知 |0|否/无 |1|是/有', name: 'inconsistentstatus', index: 'inconsistentStatus', width: 80 }, 			
			{ label: '其它瑕疵', name: 'customdefect', index: 'customDefect', width: 80 }, 			
			{ label: '是否定向交易 true定向交易 false 非定向交易', name: 'isdirectsell', index: 'isDirectSell', width: 80 }, 			
			{ label: '交易对手账号（交易对手的手机号?） 若isDirectSell为true时，该值必填', name: 'directbuyeraccount', index: 'directBuyerAccount', width: 80 }, 			
			{ label: '每十万扣款意向价格', name: 'feededuction', index: 'feeDeduction', width: 80 }, 			
			{ label: '票据状态', name: 'status', index: 'status', width: 80 }, 			
			{ label: '创建时间', name: 'createtimeinmillis', index: 'createTimeInMillis', width: 80 }, 			
			{ label: '卖方用户id', name: 'publisherid', index: 'publisherId', width: 80 }			
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
		bill: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.bill = {};
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
                var url = vm.bill.id == null ? "bill/bill/save" : "bill/bill/update";
                $.ajax({
                    type: "POST",
                    url: baseURL + url,
                    contentType: "application/json",
                    data: JSON.stringify(vm.bill),
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
                        url: baseURL + "bill/bill/delete",
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
			$.get(baseURL + "bill/bill/info/"+id, function(r){
                vm.bill = r.bill;
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