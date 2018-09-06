$(document).ready(function () {
    $(document).on("submit", "#stateForm", function (event) {
        $form = $(this);
        $.post($form.attr("action"), $form.serialize(), function (response) {
            location.reload();
        });
        event.preventDefault();
    })
})