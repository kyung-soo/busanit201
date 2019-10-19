var express = require('express');
var router = express.Router();

/* GET users listing. */
router.get('/', function(req, res, next) {
  //res.send('respond with a resource');
  res.json({"result":"success"})
});

router.post('/auth', function(req, res, next) {
  res.json({id: req.body.id, password:req.body.password})
});

module.exports = router;
