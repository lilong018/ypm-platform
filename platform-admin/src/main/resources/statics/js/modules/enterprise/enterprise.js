$(function () {

    var detailEnterpriseComponent = Vue.extend({
        template: '<i class="fa fa-file-archive-o fa-lg" aria-hidden="true" style="cursor: pointer;" v-on:click="toDetail(monId)"></i>',
        methods: {
            toDetail: function (id) {
                vm.getInfo(id);
            }
        },
        props: ['monId']
    });
    var acceptEnterpriseComponent = Vue.extend({
        template: '<i class="fa fa-hand-o-right" aria-hidden="true" style="cursor: pointer;" v-on:click="accept(monId)"></i>',
        methods: {
            accept: function (id) {
                vm.acceptTask(id);
            }
        },
        props: ['monId']
    });

    $("#jqGrid").jqGrid({
        url: baseURL + 'enterprise/enterprise/list',
        datatype: "json",
        colModel: [			
			// { label: 'id', name: 'id', index: 'id', width: 50, key: true },
			{ label: '企业姓名', name: 'name', index: 'name', width: 80 },
			{ label: '企业账号', name: 'account', index: 'account', width: 80 },
			//1：买方&卖方 2：卖方
			{ label: '用户角色 ', name: 'roleName', index: 'roleName', width: 80 },
			{ label: '创建时间', name: 'createtime', index: 'createTime', width: 80},
			{ label: '企业状态', name: 'status', index: 'status', width: 80, formatter:function (cellvalue, options, rowObject){
                    if (cellvalue == 0){
                        return "待提交企业资料"
                    }else if(cellvalue == 1){
                        return "待平台审核";
                    }else if(cellvalue == 2){
                        return "平台审核不通过";
                    }else if(cellvalue == 3){
                        return "待担保渠道审核";
                    }else if(cellvalue == 4){
                        return "担保渠道审核不通过";
                    }else if(cellvalue == 5){
                        return "待激活";
                    }else if(cellvalue == 6){
                        return "审核成功";
                    }else{
                        return "未知";
                    }
                }},
			{ label: '备注', name: 'remark', index: 'remark', width: 80 },
			{ label: '原因', name: 'reason', index: 'reason', width: 80 },
            { label: '平台名称', name: 'platformName', index: 'platformName', width: 80 },
			//用户账号-注册手机号
			{ label: '客服', name: 'handlerName', index: 'handlerName', width: 80,
                formatter: function (cellvalue, options, rowObject) {
                    if (cellvalue) {
                        return cellvalue;
                    }else{
                        return '<span id="acceptTask_' + rowObject.id + '"></span>';
                    }
                },
                sortable: false,
                align: 'center'},
            {
                label: '操作',
                width: 80,
                formatter: function (cellvalue, options, rowObject) {
                    if (rowObject.enterprise){
                        return '小明';
                    }else{
                        return '<span id="detailEnterprise_' + rowObject.id + '"></span>';
                    }
                },
                sortable: false,
                align: 'center'
            }
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
            var detailArr = $("span[id^='detailEnterprise_']");
            var len = detailArr.length;
            for (var i = 0; i < len; i++) {
                var idtmp = $(detailArr[i]).attr('id').split('_');
                var enterpriseDetail = new detailEnterpriseComponent({propsData: {monId: idtmp[1]}}).$mount('#' + $(detailArr[i]).attr('id'));
            }
            var acceptArr = $("span[id^='acceptTask_']");
            var acceptLen = acceptArr.length;
            for (var i = 0; i < acceptLen; i++) {
                var idtmp = $(acceptArr[i]).attr('id').split('_');
                var acceptEnterprise = new acceptEnterpriseComponent({propsData: {monId: idtmp[1]}}).$mount('#' + $(acceptArr[i]).attr('id'));
            }
        }
    }).navGrid('#jqGridPager', {edit: false, add: false, del: false, search: false, refresh: true, view: false});
});
function accept(id){
    console.log("进入了accept 领取任务方法");
    console.log(id);
}

var vm = new Vue({
	el:'#rrapp',
	data:{
        q: {
            name: null,
            account: null,
            status:null,
            customer: null
        },
		showList: true,
		title: null,
        customer: null,
        approveStatus:1,
        channelType:1,
		enterprise: {},
        customer:[]
    },
    created: function () {
    },
    mounted: function () {
        this.initBaseData();
    },
	methods: {
		query: function () {
			vm.reload(1);
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.enterprise = {};
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
                var url = vm.enterprise.id == null ? "enterprise/enterprise/save" : "enterprise/enterprise/update";
                $.ajax({
                    type: "POST",
                    url: baseURL + url,
                    contentType: "application/json",
                    data: JSON.stringify(vm.enterprise),
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
                        url: baseURL + "enterprise/enterprise/delete",
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
			$.get(baseURL + "enterprise/enterprise/info/"+id, function(r){
                vm.showList = false;
                vm.enterprise = r.enterprise;
            });
		},
		reload: function (event) {
			vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{
                postData: {
                    name: vm.q.name,
                    account: vm.q.account,
                    status: vm.q.status,
                    customer: vm.q.customer
                },
                page:page
            }).trigger("reloadGrid");
		},
        acceptTask: function (id) {
            $.get(baseURL + "enterprise/enterprise/accept/"+id, function(r){
                vm.reload();
            });
        },
        examine:function (status) {
            console.log(status);
            let reasons = $('#reason').val();
            let remark = $('#remark').val();
            $('#examine').button('loading').delay(1000).queue(function() {
                var url =  "enterprise/enterprise/review";
                var ajData = {};
                ajData.id = vm.enterprise.id;
                ajData.reasons = reasons;
                ajData.remark = remark;
                ajData.status = status;
                $.ajax({
                    type: "POST",
                    url: baseURL + url,
                    contentType: "application/json",
                    data: JSON.stringify(ajData),
                    success: function(r){
                        if(r.code === 0){
                            layer.msg("操作成功", {icon: 1});
                            vm.reload();
                            $('#examine').button('reset');
                            $('#examine').dequeue();
                        }else{
                            layer.alert(r.msg);
                            $('#examine').button('reset');
                            $('#examine').dequeue();
                        }
                    }
                });
            });
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
function previewImg(obj) {
    var img = new Image();
    img.src = obj.src;
    var height = img.height + 50; //获取图片高度
    var width = img.width; //获取图片宽度
    var imgHtml = "<img src='" + obj.src + "' />";
    //弹出层
    layer.open({
        type: 1,
        shade: 0.8,
        offset: 'auto',
        area: [width + 'px',height+'px'],
        shadeClose:true,//点击外围关闭弹窗
        scrollbar: false,//不现实滚动条
        title: "图片预览", //不显示标题
        content: imgHtml, //捕获的元素，注意：最好该指定的元素要存放在body最外层，否则可能被其它的相对元素所影响
        cancel: function () {
            //layer.msg('捕获就是从页面已经存在的元素上，包裹layer的结构', { time: 5000, icon: 6 });
        }
    });
}
