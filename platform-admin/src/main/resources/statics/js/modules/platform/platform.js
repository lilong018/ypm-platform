$(function () {

    var detailPlatformComponent = Vue.extend({
        template: '<i class="fa fa-file-archive-o fa-lg" aria-hidden="true" style="cursor: pointer;" v-on:click="toDetail(monId)"></i>',
        methods: {
            toDetail: function (id) {
                vm.getInfo(id);
            }
        },
        props: ['monId']
    });

    $("#jqGrid").jqGrid({
        url: baseURL + 'platform/platform/list',
        datatype: "json",
        colModel: [			
			// { label: 'id', name: 'id', index: 'id', width: 50, key: true },
			{ label: '平台名称', name: 'name', index: 'name', width: 80 }, 			
			{ label: '网络名称', name: 'website', index: 'website', width: 80 }, 			
			{ label: '负责人', name: 'manager', index: 'manager', width: 80 }, 			
			{ label: '联络电话', name: 'phoneno', index: 'phoneNo', width: 80 }, 			
			{ label: '平台状态', name: 'status', index: 'status', width: 80,formatter:function(cellvalue, options, rowObject) {
			    if(cellvalue == 1){
			        return "在线";
                }else{
			        return "离线";
                }
             } },
			{ label: '创建时间', name: 'createtimeinmillis', index: 'createTimeInMillis', width: 80 },
            {
                label: '操作',
                width: 80,
                formatter: function (cellvalue, options, rowObject) {
                    return '<span id="detailPlatform_' + rowObject.id + '"></span>';
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
        // beforeRequest: function () {
        //     $("thead th").css("text-align", "center");
        // },
        gridComplete:function(){
            //隐藏grid底部滚动条
            $("#jqGrid").closest(".ui-jqgrid-bdiv").css({ "overflow-x" : "hidden" });
            var detailArr = $("span[id^='detailPlatform_']");
            var len = detailArr.length;
            for (var i = 0; i < len; i++) {
                var idtmp = $(detailArr[i]).attr('id').split('_');
                var platformDetail = new detailPlatformComponent({propsData: {monId: idtmp[1]}}).$mount('#' + $(detailArr[i]).attr('id'));
            }
        }
    }).navGrid('#jqGridPager', {edit: false, add: false, del: false, search: false, refresh: true, view: false});
});

var vm = new Vue({
	el:'#rrapp',
	data:{
        q: {
            name: null
        },
		showList: true,
		title: null,
		platform: {}
	},
	methods: {
		query: function () {
			vm.reload(1);
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.platform = {};
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
                var url = vm.platform.id == null ? "platform/platform/save" : "platform/platform/update";
                $.ajax({
                    type: "POST",
                    url: baseURL + url,
                    contentType: "application/json",
                    data: JSON.stringify(vm.platform),
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
                        url: baseURL + "platform/platform/delete",
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
			$.get(baseURL + "platform/platform/info/"+id, function(r){
			    // if (r.platform.status == 1){
                //     r.platform.status = "在线";
                // }else{
                //     r.platform.status ="离线";
                // }
                vm.showList = false;
                vm.platform = r.platform;
            });
		},
		reload: function (event) {
			vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{
                postData: {
                    name: vm.q.name
                },
                page:page
            }).trigger("reloadGrid");
		}
	}
});