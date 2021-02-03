$(function () {
    var acceptBillComponent = Vue.extend({
        template: '<i class="fa fa-hand-o-right" aria-hidden="true" style="cursor: pointer;" v-on:click="accept(monId)"></i>',
        methods: {
            accept: function (id) {
                vm.acceptBillTask(id);
            }
        },
        props: ['monId']
    });

    $("#jqGrid").jqGrid({
        url: baseURL + 'bill/bill/list',
        datatype: "json",
        colModel: [
            {label: 'id', name: 'id', index: 'id', width: 50, key: true},
            {label: '票号', name: 'number', index: 'number', width: 80},
            {label: '承兑人', name: 'acceptingbankname', index: 'acceptingBankName', width: 80},
            {label: '卖方名称', name: 'drawername', index: 'drawerName', width: 80},
            {
                label: '担保渠道',
                name: 'channeltype',
                index: 'channelType',
                width: 80,
                formatter: function (cellvalue, options, rowObject) {
                    if (cellvalue == 1) {
                        return "京东智票"
                    } else if (cellvalue == 2) {
                        return "京东智付";
                    } else if (cellvalue == 3) {
                        return "京东智票，京东智付";
                    } else {
                        return "未知";
                    }
                }
            },
            {label: '到期日', name: 'duedate', index: 'dueDate', width: 80},
            {label: '票面金额(元)', name: 'amount', index: 'amount', width: 80},
            {label: '意向价格(元)', name: 'feededuction', index: 'feeDeduction', width: 80},
            {label: '收票人姓名', name: 'draweename', index: 'draweeName', width: 80},
            {label: '承兑银行行号', name: 'acceptingbanknumber', index: 'acceptingBankNumber', width: 80},
            {
                label: '承兑银行类型',
                name: 'acceptingbanktype',
                index: 'acceptingBankType',
                width: 80,
                formatter: function (cellvalue, options, rowObject) {
                    if (cellvalue == 0) {
                        return "国股"
                    } else if (cellvalue == 1) {
                        return "大商";
                    } else if (cellvalue == 2) {
                        return "城商";
                    } else if (cellvalue == 3) {
                        return "三农";
                    } else if (cellvalue == 4) {
                        return "村镇";
                    } else if (cellvalue == 5) {
                        return "外资";
                    } else if (cellvalue == 6) {
                        return "民营";
                    } else if (cellvalue == 7) {
                        return "财务 (财票)";
                    } else if (cellvalue == 8) {
                        return "企业(商票)";
                    } else {
                        return "未知";
                    }
                }
            },
            {
                label: '票据状态',
                name: 'status',
                index: 'status',
                width: 80,
                formatter: function (cellvalue, options, rowObject) {
                    if (cellvalue == 0) {
                        return "待审核"
                    } else if (cellvalue == 1) {
                        return "审核中";
                    } else if (cellvalue == 2) {
                        return "审核通过且已上架";
                    } else if (cellvalue == 3) {
                        return "审核未通过";
                    } else if (cellvalue == 4) {
                        return "交易中";
                    } else if (cellvalue == 5) {
                        return "已交易";
                    } else {
                        return "未知";
                    }
                }
            },
            { label: '客服', name: 'customerName', index: 'customerName', width: 80,
                formatter: function (cellvalue, options, rowObject) {
                    if (cellvalue) {
                        return cellvalue;
                    }else{
                        return '<span id="acceptTask_' + rowObject.id + '"></span>';
                    }
                },
                sortable: false,
                align: 'center'}
        ],
        viewrecords: true,
        height: 385,
        rowNum: 10,
        rowList: [10, 30, 50],
        rownumbers: true,
        rownumWidth: 25,
        autowidth: true,
        multiselect: true,
        pager: "#jqGridPager",
        jsonReader: {
            root: "page.list",
            page: "page.currPage",
            total: "page.totalPage",
            records: "page.totalCount"
        },
        prmNames: {
            page: "page",
            rows: "limit",
            order: "order"
        },
        gridComplete: function () {
            //隐藏grid底部滚动条
            $("#jqGrid").closest(".ui-jqgrid-bdiv").css({"overflow-x": "hidden"});
            var acceptArr = $("span[id^='acceptTask_']");
            var acceptLen = acceptArr.length;
            for (var i = 0; i < acceptLen; i++) {
                var idtmp = $(acceptArr[i]).attr('id').split('_');
                var acceptBill = new acceptBillComponent({propsData: {monId: idtmp[1]}}).$mount('#' + $(acceptArr[i]).attr('id'));
            }
        }
    }).navGrid('#jqGridPager', {edit: false, add: false, del: false, search: false, refresh: true, view: false});
});
function accept(id){
    console.log("进入了accept 领取任务方法");
    console.log(id);
}

var vm = new Vue({
    el: '#rrapp',
    data: {
        q: {
            type: null,
            number: null,
            amount: null,
            sdate: null,
            edate: null,
            sellerId: null,
            buyerId: null,
            qcustomer: null
        },
        showList: true,
        title: null,
        approveStatus: 1,
        bill: {}
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
        add: function () {
            vm.showList = false;
            vm.title = "新增";
            vm.bill = {};
        },
        update: function (event) {
            var id = getSelectedRow();
            if (id == null) {
                return;
            }
            vm.showList = false;
            vm.title = "修改";

            vm.getInfo(id)
        },
        saveOrUpdate: function (event) {
            $('#btnSaveOrUpdate').button('loading').delay(1000).queue(function () {
                var url = vm.bill.id == null ? "bill/bill/save" : "bill/bill/update";
                $.ajax({
                    type: "POST",
                    url: baseURL + url,
                    contentType: "application/json",
                    data: JSON.stringify(vm.bill),
                    success: function (r) {
                        if (r.code === 0) {
                            layer.msg("操作成功", {icon: 1});
                            vm.reload();
                            $('#btnSaveOrUpdate').button('reset');
                            $('#btnSaveOrUpdate').dequeue();
                        } else {
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
            if (ids == null) {
                return;
            }
            var lock = false;
            layer.confirm('确定要删除选中的记录？', {
                btn: ['确定', '取消'] //按钮
            }, function () {
                if (!lock) {
                    lock = true;
                    $.ajax({
                        type: "POST",
                        url: baseURL + "bill/bill/delete",
                        contentType: "application/json",
                        data: JSON.stringify(ids),
                        success: function (r) {
                            if (r.code == 0) {
                                layer.msg("操作成功", {icon: 1});
                                $("#jqGrid").trigger("reloadGrid");
                            } else {
                                layer.alert(r.msg);
                            }
                        }
                    });
                }
            }, function () {
            });
        },
        getInfo: function (id) {
            $.get(baseURL + "bill/bill/info/" + id, function (r) {
                vm.bill = r.bill;
            });
        },
        reload: function (event) {
            vm.showList = true;
            var page = $("#jqGrid").jqGrid('getGridParam', 'page');
            $("#jqGrid").jqGrid('setGridParam', {
                postData: {
                    type: vm.q.type,
                    number: vm.q.number,
                    amount: vm.q.amount,
                    sdate: vm.q.sdate,
                    edate: vm.q.edate,
                    sellerId: vm.q.sellerId,
                    buyerId: vm.q.buyerId,
                    customer: vm.q.customer
                },
                page: page
            }).trigger("reloadGrid");
        },
        acceptBillTask: function (id) {
            $.get(baseURL + "bill/bill/accept/"+id, function(r){
                vm.reload();
            });
        },
        examine: function (status) {
            console.log(status);
            let reasons = $('#reason').val();
            let remark = $('#remark').val();
            $('#examine').button('loading').delay(1000).queue(function () {
                var url = "bill/bill/review";
                var ajData = {};
                ajData.id = vm.bill.id;
                ajData.status = status;
                ajData.reasons = reasons;
                ajData.remark = remark;
                console.log('ajData',ajData);
                $.ajax({
                    type: "POST",
                    url: baseURL + url,
                    contentType: "application/json",
                    data: JSON.stringify(ajData),
                    success: function (r) {
                        if (r.code === 0) {
                            layer.msg("操作成功", {icon: 1});
                            vm.reload();
                            $('#examine').button('reset');
                            $('#examine').dequeue();
                        } else {
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
                        console.log(r.employeeEntities);
                        _self.customer = r.employeeEntities;
                        Vue.nextTick(function () {
                            _self.initQyChosenCustomer();
                        });
                    }
                }
            });
        },
        initQyChosenCustomer: function () {
            var optionHtml = '';
            optionHtml += '<option value="">' + "请选择客服" + '</option>';
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
            qcustomer.on('change', function (evt, params) {
                //赋值
                vm.q.customer = qcustomer.val();
            });
        }
    }
});