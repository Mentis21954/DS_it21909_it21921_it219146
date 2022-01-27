/**
 * 
 */

$(document).ready(function(){
    $('.editApplication').on('click',function(event){
        event.preventDefault();

        var href = $(this).attr('href');
        $.get(href, function(application,status){
            $('#usernameEdit').val(users.username);
            $('#authorityEdit').val(authorities.name);
            
        });        

        $('#editModal').modal();
    });
});
