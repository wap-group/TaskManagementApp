/*
 $('form').serializeArray(): coverts a form to an array
 $('form').toObject(): converts a form into an object (value, pair)  with properties reflecting the names of the field in the form.

 */

usersController = function() {

	function errorLogger(errorCode, errorMessage) {
		console.log(errorCode +':'+ errorMessage);
	}

	var userPage;
	var initialised = false;

	function taskCountChanged() {
		var count = $(userPage).find( '#tblTasks tbody tr').length;
		$('footer').find('#taskCount').text(count);
	}

	function clearTask() {
		$().find('form').fromObject({});
	}

	function renderTable() {
		$.each($(userPage).find('#tblTasks tbody tr'), function(idx, row) {
			var due = Date.parse($(row).find('[datetime]').text());
			if (due.compareTo(Date.today()) < 0) {
				$(row).addClass("overdue");
			} else if (due.compareTo((2).days().fromNow()) <= 0) {
				$(row).addClass("warning");
			}
		});
	}

	return {
		init : function(page, callback) {
			if (initialised) {
				callback()
			} else {
				userPage = page;
				storageEngine.init(function() {
					storageEngine.initObjectStore('task', function() {
						callback();
					}, errorLogger)
				}, errorLogger);
				$(userPage).find('[required="required"]').prev('label').append( '<span>*</span>').children( 'span').addClass('required');
				$(userPage).find('tbody tr:even').addClass('even');

				$(userPage).find('#btnAddTask').click(function(evt) {
					evt.preventDefault();
					$(userPage).find('#taskCreation').removeClass('not');
				});

				$(userPage).find('#tblTasks tbody').on('click', 'tr', function(evt) {
					$(evt.target).closest('td').siblings().andSelf().toggleClass('rowHighlight');
				});

				$(userPage).find('#tblTasks tbody').on('click', '.deleteRow',
					function(evt) {
						storageEngine.delete('task', $(evt.target).data().taskId,
							function() {
								$(evt.target).parents('tr').remove();
								taskCountChanged();
							}, errorLogger);

					}
				);

				$(userPage).find('#tblTasks tbody').on('click', '.editRow',
					function(evt) {
						$(userPage).find('#taskCreation').removeClass('not');
						storageEngine.findById('task', $(evt.target).data().taskId, function(task) {
							$(userPage).find('form').fromObject(task);
						}, errorLogger);
					}
				);

				$(userPage).find('#clearTask').click(function(evt) {
					evt.preventDefault();
					clearTask();
				});

				$(userPage).find('#tblTasks tbody').on('click', '.completeRow', function(evt) {
					storageEngine.findById('task', $(evt.target).data().userId, function(task) {
						task.complete = true;
						storageEngine.save('task', task, function() {
							tasksController.loadTasks();
						},errorLogger);
					}, errorLogger);
				});

				$(userPage).find('#saveTask').click(function(evt) {
					evt.preventDefault();
					if ($(userPage).find('form').valid()) {
						var task = $(userPage).find('form').toObject();
						storageEngine.save('task', task, function() {
							$(userPage).find('#tblTasks tbody').empty();
							tasksController.loadTasks();
							clearTask();
							$(userPage).find('#taskCreation').addClass('not');
						}, errorLogger);
					}
				});
				initialised = true;
			}
		},
		loadTasks : function() {
			$(userPage).find('#tblTasks tbody').empty();
			storageEngine.findAll('task', function(tasks) {
				tasks.sort(function(o1, o2) {
					return Date.parse(o1.requiredBy).compareTo(Date.parse(o2.requiredBy));
				});
				$.each(tasks, function(index, task) {
					if (!task.complete) {
						task.complete = false;
					}
					$('#taskRow').tmpl(task).appendTo($(userPage).find('#tblTasks tbody'));
					taskCountChanged();
					renderTable();
				});
			}, errorLogger);
		}
	}
}();
