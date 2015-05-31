google.load("visualization", "1", {packages:["corechart"]});
google.setOnLoadCallback( drawChart );

var languageData = window.data.map( function( elem ) {
  console.log( [elem._id, elem.value] );
  return [elem._id, elem.value];
} );


function drawChart() {

  var data = new google.visualization.DataTable();
  data.addColumn( "string" , "Language" );
  data.addColumn( "number", "Lines of code" );

  console.log( languageData );
  data.addRows( languageData );

  var options = {
    title: "Language use in GitHub repositories",
    width: 800,
    height: 800
  };

  var chart = new google.visualization.PieChart( $("div#chart")[0] );
  chart.draw( data, options );

}
