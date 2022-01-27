/**
 * 
 */

$(document).ready(function(){
    $('.editApplication').on('click',function(event){
        event.preventDefault();

        var href = $(this).attr('href');
        $.get(href, function(application,status){
			$('#idEdit').val(users.user_id);
            $('#usernameEdit').val(users.username);
            $('#authorityEdit').val(authorities.name);
            
        });        

        $('#editModal').modal();
    });
});
