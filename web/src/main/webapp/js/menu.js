y1 = 0; // background-position open
y2 = -16; // background-position close
ac = 0;
var set = {
	'menu-0' : { // settings var name = menu id
		'h' : 1, // header image: 0(false), 1(true)
		'i' : 0, // initial expanding level
		'j' : 1, // jump backwards: 0(false), 1(true)
		'l' : 3, // must be set to the maximum menulevel
		'm' : 0, // mouseover: 0(false), 1(true)
		'p' : 0, // position: 0(vertical), 1(horizontal)
		's' : 'normal', // speed: 'fast', 'normal', 'slow', ...
		't' : 1
	// toggle: 0(self open, else close), 1(self toggle, else close), 2(self
	// toggle)
	},
	'menu-1' : {
		'h' : 1,
		'i' : 1,
		'j' : 0,
		'l' : 3,
		'm' : 0,
		'p' : 1,
		's' : 'slow',
		't' : 1
	}
};
function acxmenu(x) {
	if (ac == 1)
		return false;
	else
		ac = 1;
	var b = $(x), c = b.closest('.menu-0'); 
	//alert(c.toSource());
	//if (c[0] != undefined) {
	var d = c[0].id;
	var m = b.next();
	var n, o, p = [], q = [];
	var r = set[d];
	var i, j, h, w;
	for (i = 1; i <= r.l; i++) {
		n = '#' + d + ' .menu-' + i;
		o = m.index(n);
		p[i] = b.closest(n);
		if (o >= 0) {
			if (r.t === 0 || (r.t > 0 && m.is(':hidden')))
				p[i] = m;
			if (r.t === 0 || (r.t == 1 && m.is(':hidden'))
					|| (r.t == 2 && m.is(':visible')))
				q[i] = o;
		}
		if (r.t < 2) {
			q[i] = p[i].index(n);
			j = q[i] >= 0 ? ':not(:eq(' + q[i] + '))' : '';
		} else
			j = ':eq(' + q[i] + ')';
		h = r.p < 1 ? 'hide' : b.outerHeight();
		w = r.p > 0 ? 'hide' : b.outerWidth();
		c.find('.menu-' + i + j).animate({
			height : h,
			width : w
		}, r.s);
		imgpos(c.find('.cabecera-' + i + j), y2);
		if (r.p < 1)
			h = 'show';
		else
			w = 'show';
		p[i].animate({
			height : h,
			width : w
		}, r.s);
		imgpos(p[i].prev(), y1);
	}
	c.find('a').removeClass('lm');
	b.addClass('lm').focus();
	setTimeout(function() {
		ac = 0;
	}, 333);
	//}
}
function imgpos(i, p) {
	i.find('span').css('background-position', "0 " + p + "px");
}
function knav(x, e, k) {
	if (k == 9) {
		k = e.shiftKey ? 38 : 40;
		knav(x, e, k);
		e.preventDefault();
		return false;
	}
	var c = $(x).closest('.menu-0'), a = c.find('a'), d = c[0].id, i = a.index(x), l = a.length, p;
	if (k > 36 && k < 41) {
		if (k < 39)
			i = (i === 0) ? l - 1 : i - 1;
		else
			i = (i == l - 1) ? 0 : i + 1;
		if (set[d].j > 0) {
			p = a.eq(i).closest('div[class*="menu-"]');
			if (p.is(':hidden'))
				i = a.index(p.prev());
		}
		acxmenu('#' + d + ' a:eq(' + i + ')');
	}
	if (k == 13)
		$(x).attr('href');
}
$(function() {
	for ( var i in set) {
		var j, r = set[i], m = $('#' + i), n;
		for (j = r.l; j > 0; j--) {
			if (r.h == 1)
				m.find('.cabecera-' + j).append("<span class='imagen-cabecera'></span>");
			if (r.i < j) {
				n = m.find('.menu-' + j);
				n.hide();
				if (r.h == 1)
					imgpos(n.prev(), y2);
			}
		}
	}
	$('#menu-0 a,#menu-1 a').click(function() {
		acxmenu(this);
	}).keydown(function(e) {
		knav(this, e, e.which);
	}).mouseover(function() {
		var r = set[$(this).closest('.menu-0')[0].id];
		if (r.m > 0)
			acxmenu(this);
	});
	$('.imagen-cabecera').click(function() {
		acxmenu($(this).parent());
		return false;
	});
	// optional
	$('#smap').unbind('click').click(function() {
		acxmenu('#menu-0 a');
		$('#menu-0 a').removeClass('lm');
		$(this).addClass('lm').focus();
	});
	acxmenu('#menu-0 a:eq(0)');
	$('p').eq(1).click(function() {
		acxmenu('#menu-0 a[href*="menu-0"]');
	});
	$('a[href=""]').click(function() {
		return false;
	});
});
