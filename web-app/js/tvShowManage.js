(function() {
  jQuery(function() {
    var content, tags;
    content = $('#tvShows');
    tags = ['.sales-focus', '.service-focus', '.other-focus'];
    return $.each(content.find('.tvShowRemoveWatch'), function(button) {
      return alert('found' + button.attr(id));
    });
  });
}).call(this);
