$("a.tvShowAddWatch").click(function(){ 
    var tvshow_id = $(this).data("id"); 
    $.post(URLRoot+"/TVShow/jsonWatcherAdd", {id: tvshow_id, user_id: userID}) 
    $("#tvShowRemoveWatch_"+tvshow_id).toggle();
    $("#tvShowAddWatch_"+tvshow_id).toggle();
}); 
$("a.tvShowRemoveWatch").click(function(){ 
    var tvshow_id = $(this).data("id"); 
    $.post(URLRoot+"/TVShow/jsonWatcherRemove", {id: tvshow_id, user_id: userID}) 
    $("#tvShowRemoveWatch_"+tvshow_id).toggle();
    $("#tvShowAddWatch_"+tvshow_id).toggle();
}); 