jQuery(document).ready(function () {

        $('#parseDate').on('click', function () {
            $.ajax({
                url: '/temporalResolution/parseDate',
                type: 'GET',
                data: {text: $('#getDay').val()},
                success: function (data) {
                    console.log(data)
                    $('#setDate').val(data)
                }
            });
        });
    }
)