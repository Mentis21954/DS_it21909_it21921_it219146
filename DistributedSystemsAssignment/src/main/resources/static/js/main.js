/**
 * 
 */

$(document).ready(function(){
    $('.editApplication').on('click',function(event){
        event.preventDefault();

        var href = $(this).attr('href');
        $.get(href, function(application,status){
            $('#nameEdit').val(nationality.name);
            $('#lnameEdit').val(nationality.lname);
            $('#emailEdit').val(nationality.email);
            $('#bitrhDateEdit').val(nationality.birtDate);
            $('#idEdit').val(nationality.idNumber);
            $('#afmEdit').val(nationality.AFM);
            $('#amkaEdit').val(nationality.AMKA);
            $('#maritalEdit').val(nationality.maritalStatus);
            $('#nationalityEdit').val(nationality.primaryNationality);
            $('#cityEdit').val(nationality.city);
            $('#unemploymentEdit').val(nationality.dateOfUnemployment);
            $('#photoEdit').val(nationality.photo);
            $('#incomeEdit').val(nationality.income);
        });        

        $('#editModal').modal();
    });
});
