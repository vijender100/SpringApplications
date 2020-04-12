var app = angular.module("EmployeeManagement", []);
 
// Controller Part
app.controller("EmployeeController", function($scope, $http) {
 
 
    $scope.employees = [];
    $scope.employeeForm = {empId:"",
            empName: "",
            empSal:""
        };
    $scope.employeeForm=new Object();  
    emp.id=0;  
    emp.name="";  
    emp.salary=0.0;
       
    var method = "";
    var url = "";
   
    //_refreshEmployeeData();
 
   
    $scope.submitEmployee = function() {
 
       
 
        $http({
            method: 'POST',
            url: '/saveEmp',
            data: angular.toJson($scope.employeeForm),
            //console.alert(data);
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(_success, _error);
    };
 
    $scope.createEmployee = function() {
        _clearFormData();
    }
 
    
    $scope.deleteEmployee = function(employee) {
        $http({
            method: 'DELETE',
            url: '/employee/' + employee.empId
        }).then(_success, _error);
    };
 
   
    $scope.editEmployee = function(employee) {
        $scope.employeeForm.empId = employee.empId;
        $scope.employeeForm.empName = employee.empName;
        $scope.employeeForm.empSal = employee.empSal;
    };
 
   
    function _refreshEmployeeData() {
        $http({
            method: 'GET',
            url: '/getAll'
        }).then(
            function(res) { // success
                $scope.employees = res.data;
             
            },
            function(res) { // error
                //console.log("Error: " + res.status + " : " + res.data);
            }
        );
    }
 
    function _success(res) {
        _refreshEmployeeData();
        _clearFormData();
    }
 
    function _error(res) {
        var data = res.data;
        var status = res.status;
        var header = res.header;
        var config = res.config;
        alert("Error: " + status + ":" + data);
    }
 
    
    function _clearFormData() {
        $scope.employeeForm.empId = -1;
        $scope.employeeForm.empName = "";
        $scope.employeeForm.empSal = ""
    };
});