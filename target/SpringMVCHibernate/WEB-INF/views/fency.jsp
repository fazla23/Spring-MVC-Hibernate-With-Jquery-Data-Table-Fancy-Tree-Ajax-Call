<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>information</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <script src="//code.jquery.com/jquery-3.6.0.min.js"></script>
    <link href="//cdn.jsdelivr.net/npm/jquery.fancytree@2.27/dist/skin-win8/ui.fancytree.min.css" rel="stylesheet">
    <script src="//cdn.jsdelivr.net/npm/jquery.fancytree@2.27/dist/jquery.fancytree-all-deps.min.js"></script>

</head>
<body>

<p>Load from Ajax data:</p>
<div id="tree2" data-source="ajax" class="sampletree">
</div>


<script type="text/javascript">

    // Load tree from Ajax JSON
    $("#tree2").fancytree({
      source: {
        url: "http://localhost:8080/SpringMVCHibernate/students/tree"
      },
      lazyLoad: function(event, data){
        data.result = $.ajax({
          url: "http://localhost:8080/SpringMVCHibernate/students/tree",
          dataType: "json"
        });
      }
    });
</script>
</body>

</html>
