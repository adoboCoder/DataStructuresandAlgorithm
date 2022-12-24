using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using MyApi.Models;

namespace MyApi.Controllers
{   [ApiController]
    public class ValuesController : ApiController
    {
        private readonly MyDbContext _context;

        public ValuesController(MyDbContext context)
        {
            _context = context;
        }

        // GET api/values
        [HttpGet]
        //[Route("api/values/{id}/{param1}/{param2}")]
        public async Task<IEnumerable<string>> GetValues(int minLength)
        {
            var values = await _context.Values
                .Where(v => v.Name.Length >= minLength)
                .Select(v => v.Name)
                .ToList();
            return values;
        }
    }
}
