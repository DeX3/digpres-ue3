
conn = new Mongo();
db = conn.getDB( "github" );

var c = db["github-1433087347666"];

var languages = c.mapReduce(
  function() {
    var languages = Object.keys(this.languages);

    for( var i=0 ; i < languages.length ; i++ ) {
      var lang = languages[i];
      emit( lang, this.languages[lang] );
    }
  },
  function( key, values ) {
    return Array.sum( values );
  },
  {
      query: {},
      out: "languages"
  }
);


printjson( languages );
