jQuery -> 
  content = $('#tvShows')
  #container = content.find('.container')

  tags = [
      '.sales-focus'
      '.service-focus'
      '.other-focus'
  ]

  $.each content.find('.tvShowRemoveWatch'), (button) ->
      alert('found'+button.attr(id))