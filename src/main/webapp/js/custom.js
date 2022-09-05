// get all user
$(document).ready(function(){
  console.log("OK")
	  $.ajax({
	  url: 'http://localhost:8080/crm_project/api/user',
	  type: 'get',
	  dataType:"json"
	}).done(function(value) {
		console.log(value)
		var index = 1;
		value.forEach(function(data){
			var contentUser = `
		<tr>
			<td>${index++}</td>
			<td>${data.code}</td>
			<td>${data.name}</td>
			<td>${data.email}</td>
			<td>${data.phone}</td>
			<td>${data.roleId}</td>
			<td><a href="#" class="btn btn-sm btn-primary">Sửa</a> <a
				href="./deleteUser?id=${data.id}" class="btn btn-sm btn-danger">Xóa</a> <a
				href="user-details.html" class="btn btn-sm btn-info">Xem</a>
			</td>
		</tr>
		`
		$('#tbody-users').append(contentUser)
		})
		
	}).fail(function(error) {
	
	});
  
}); 
