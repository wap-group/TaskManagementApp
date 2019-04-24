$(document).ready(function(){

    console.log("page loaded");


    $("jsGrid").jsGrid("option", "data", []);

    var MyDateField = function(config){
        jsGrid.Field.call(this, config);
    };

    MyDateField.prototype = new jsGrid.Field({

        css: "date-field",
        align: "center",

        myCustomProperty: "foo",

        itemTemplate: function(value){
            return new Date(value).toDateString();
        } ,

        insertTemplate: function(value){
            return this._insertPicker = $("<input>").datepicker({default: new Date()});
        },

        editTemplate: function(value){
            return this._editPicker = $("<input>").datepicker().datepicker("setDate", new Date(value));
        },

        insertValue: function(){
            return this._insertPicker.datepicker("getDate").toISOString();
        },

        editValue: function(){
            return this._editPicker.datepicker("getDate").toISOString();
        },

    });

    jsGrid.fields.date = MyDateField;


    $("#task-grid").jsGrid({

        height: "80%",
        width: "100%",
        editing: true,
        sorting: true,
        paging: true,
        filtering: true,
        filterRowRenderer: null,
        filterRowClass: "jsgrid-filter-row",
        autoload: true,
        pageSize: 10,
        controller: {
            loadData: function(filter) {
                let d = $.Deferred();

                // server-side filtering
                $.ajax({
                    type: "GET",
                    url: "../../DeveloperServlet",
                    data: filter,
                    dataType: "json"
                }).done(function(result) {
                    // client-side filtering
                    result = $.grep(result, function(item) {
                        return item.SomeField === filter.SomeField;
                    });

                    d.resolve(result);
                })

                return d.promise();
            },

            insertItem: function (item) {
                let data = $.Deferred();
                $.ajax({
                    type: "POST",
                    url: "../../DeveloperServlet",
                    data: item,
                    datatype: "json"
                }).done(function(response){
                    //data.resolve(response);
                    setTimeout(function(){$("#task-grid").jsGrid("loadData")}, 500);
                });
            },

            updateItem: function(item) {
                //let status = item.taskStatus;
                //console.log("Upated value: " + status);
                //if(status === "Not started" || status === "In progress" || status === "Completed"){
                var data = $.Deferred();
                return $.ajax({
                    type: "PUT",
                    url: "../../DeveloperServlet",
                    data: item,
                    datatype: "json"
                }).done(function(response){

                });
                return data.promise();
            }

        },

        fields: [
            {name: "taskId", title: "Task Id", type: "number", width: "50px", editing: false},
            {name: "taskName", title: "Task Name", type: "text", validate: "required", width: "60px", editing: false},
            {name: "dueDate", title: "Du eDate", type: "text", validate: "required", width: "50px", editing: false},

            /*{name: "pass_word", title: "Pw", type: "text", validate: "required", width: "50px"},
            {name: "email", title: "Email", type: "text", validate: "required", width: "100px"},
            */
            {name: "priority", title: "Priority", type: "number", validate: "required", width: "40px",  editing: false},
            {name: "category", title: "Category", type: "text", validate: "required", width: "60px",  editing: false},
            {name: "taskDescription", title: "Description", type: "text", validate: "required", width: "80px",  editing: false},
            {name: "taskStatus", title: "Status", type: "text", valueField: "taskStatus", width: "60px"},
           /*
            {name: "taskStatus", title: "Status", type: "select", validate: "required", valueField: "taskStatus", width: "80px",
                items:["Not started","In progress", "Completed"], autosearch: true, selectedIndex: 0},*/

            {name: "taskAssigned", title: "Date Assigned", type: "text", validate: "required", width: "60px",  editing: false},
            {type: "control", deleteButton: false}
        ]

    });

});
