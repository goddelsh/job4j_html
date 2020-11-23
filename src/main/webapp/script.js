
function validate() {
    let name = $('#name').val();
    let surname = $('#sname').val();
    let gender = getSelectedText("gender");
    let description = $('#description').val();
    let result = "";
    if (name == "") {
        result += "Name: undefined\n";     
    } else {
        result += "Name: " + name + "\n";
    }
    if (surname == "") {
        result += "Surname: undefined\n";     
    } else {
        result += "Surname: " + surname + "\n";
    }
    if (gender == "") {
        result += "Gender: undefined\n";     
    } else {
        result += "Gender: " + gender + "\n";
    }
    if (description == "") {
        result += "Description: undefined\n";     
    } else {
        result += "Description: " + description + "\n";
    }
    $('#table tr:last').after('<tr><td>' + name +'</td></tr>');
    alert(result);

    return false;
}


function addRow(){
    let name = $('#name').val();
    let surname = $('#sname').val();
    let gender = getSelectedText("gender");
    let description = $('#description').val();
    $('#tbody tr:last').after('<tr><td>' + name +'</td><td>'
     + surname +'</td><td>' + gender
      + '</td><td>' + description + '</td></tr>');
    return false;
}
function getSelectedText(elementId) {
    var elt = document.getElementById(elementId);
  
    if (elt.selectedIndex == -1)
      return null;
  
    return elt.options[elt.selectedIndex].text;
  }
  