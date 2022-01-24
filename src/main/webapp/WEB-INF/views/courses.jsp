<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>information</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js" integrity="sha512-894YE6QWD5I59HgZOGReFYm4dnWc1Qt5NtvYSaNcOP+u1T9qYdvdihz0PPSiiqn/+/3e7Jo4EaG7TubfWGUrMQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.11.3/css/jquery.dataTables.css">
    <script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.11.3/js/jquery.dataTables.js"></script>

</head>
<body>
<section class="content">
    <div class="container-fluid">
        <table id="example" class="display" style="width: 100%">
            <thead>
            <tr>
                <th>Student Name</th>
                <th>Student Roll</th>
                <th>Course Name</th>
                <th>Course type</th>
            </tr>
            </thead>
        </table>
    </div>
</section>

<script>
    $('#example').DataTable({
            processing: true,
            ajax:{url:"http://localhost:8080/SpringMVCHibernate/courses/getall",dataSrc:""},
            columns: [
                { data: 'name' },
                { data: 'roll' },
                { data:'courseList[].name'},
                { data:'courseList[].type'}
            ]
        }
    );
</script>
</body>
</html>
