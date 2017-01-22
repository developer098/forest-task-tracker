Ext.define('ForestTaskTracker.store.ForestTasks', {
    extend: 'Ext.data.Store',

    alias: 'store.foresttasks',
    autoLoad: true,
    requires: ['ForestTaskTracker.model.ForestTask'],
    model: 'ForestTaskTracker.model.ForestTask',
    proxy: {
        type: 'ajax',
        url:'rest/ftasks.json',
        reader: {
            type: 'json'
        }
    }
});
