Ext.define('ForestTaskTracker.model.ForestTask', {
    extend: 'Ext.data.Model',    
    fields: [
        { name: 'id', type: 'int', useNull:true },
        { name: 'description', type: 'string' }
    ]
});
