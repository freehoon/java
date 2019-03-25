
ClassicEditor
	.create( document.querySelector( '#content' ), {
		toolbar: [ 'heading', '|', 'undo', 'redo', 'bold', 'italic', 'link', 'bulletedList', 'numberedList', 'blockQuote', 'imageUpload','mediaEmbed', 'insertTable' ]
		, heading: {
			options: [
				{ model: 'paragraph', title: 'Paragraph', class: 'ck-heading_paragraph' },
				{ model: 'heading1', view: 'h1', title: 'Heading 1', class: 'ck-heading_heading1' },
				{ model: 'heading2', view: 'h2', title: 'Heading 2', class: 'ck-heading_heading2' },
				{ model: 'heading3', view: 'h3', title: 'Heading 3', class: 'ck-heading_heading3' },
			]
		}
//		, uploadUrl: '/restBoard/uploadImage'

	})
	.then( editor => {
		console.log(ClassicEditor.builtinPlugins.map( plugin => plugin.pluginName ));
		console.log(Array.from( editor.ui.componentFactory.names() ));
		console.log( editor );
	} )
	.catch( error => {
		console.error( error );
	} );

