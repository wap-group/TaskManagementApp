$(function(){
    console.log("Window Ready")

    $(".editStatus").click(changeStatus);
    $("#sortTable").click(sortTable);
});
var statusCell = null;
function changeStatus(event){
    event.preventDefault();
    statusCell = $(this).closest("tr").find(".status");
   newStatus(statusCell );
   //let newStatus = $(this).val();
    console.log("Status: " + newStatus);
}

function newStatus() {
    let form = $("#selectStatus")[0];
    if (form.style.display === "none") {
        form.style.display = "block";
    }
    $("#saveStatus").click(function(){
    let sts = $("#selector").val();
    console.log(sts);
        statusCell.text(sts);
    });
}

function sortTable() {
    console.log("Sorting table ...");

    var table, rows, switching, i, x, y, shouldSwitch;
    table = document.getElementById("userTasks");
    switching = true;
    /* Make a loop that will continue until
    no switching has been done: */
    while (switching) {
        // Start by saying: no switching is done:
        switching = false;
        rows = table.rows;
        /* Loop through all table rows (except the
        first, which contains table headers): */
        for (i = 1; i < (rows.length - 1); i++) {
            // Start by saying there should be no switching:
            shouldSwitch = false;
            /* Get the two elements you want to compare,
            one from current row and one from the next: */
            x = rows[i].getElementsByTagName("TD")[0];
            y = rows[i + 1].getElementsByTagName("TD")[0];
            // Check if the two rows should switch place:
            if (x.innerHTML.toLowerCase() > y.innerHTML.toLowerCase()) {
                // If so, mark as a switch and break the loop:
                shouldSwitch = true;
                break;
            }
        }
        if (shouldSwitch) {
            /* If a switch has been marked, make the switch
            and mark that a switch has been done: */
            rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
            switching = true;
        }
    }
}